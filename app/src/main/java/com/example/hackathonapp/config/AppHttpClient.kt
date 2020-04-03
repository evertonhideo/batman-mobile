package com.example.hackathonapp.config

import br.com.zup.beagle.annotation.BeagleComponent
import br.com.zup.beagle.networking.*
import com.example.hackathonapp.di.NetworkProvider
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.io.IOException

private const val AUTHORIZATION_HEADER = "Authorization"

object Session {
	var authorizationValue: String? = null
}

@BeagleComponent
class AppHttpClient : HttpClient {

	override fun execute(
		request: RequestData,
		onSuccess: (responseData: ResponseData) -> Unit,
		onError: (throwable: Throwable) -> Unit
	): RequestCall {
		val requestBuilder = Request.Builder()
			.url(request.uri.toString())

		addMethod(request, requestBuilder)
		addHeaders(request.headers, requestBuilder)

		val requestCall = NetworkProvider.okHttpClient.newCall(requestBuilder.build())
		requestCall.enqueue(object: Callback {
			override fun onFailure(call: Call, e: IOException) {
				onError(e)
			}

			override fun onResponse(call: Call, response: Response) {
				if (response.isSuccessful) {
					val body = response.body?.bytes() ?: byteArrayOf()
					val headers = mutableMapOf<String, String>()
					(0 until response.headers.size).forEach {
						val headerName = response.headers.name(it)
						val headerValue = response.headers.value(it)
						headers[headerName] = headerValue
					}
					val responseData = ResponseData(response.code, body, headers)
					parseAuthorizationHeader(response)
					onSuccess(responseData)
				} else {
					onError(IOException("Unexpected error with status code ${response.code}"))
				}
			}
		})

		return object: RequestCall {
			override fun cancel() {
				requestCall.cancel()
			}
		}
	}

	private fun addHeaders(headers: Map<String, String>, requestBuilder: Request.Builder) {
		Session.authorizationValue?.let {
			requestBuilder.addHeader(AUTHORIZATION_HEADER, it)
		}
		headers.forEach {
			requestBuilder.addHeader(it.key, it.value)
		}
	}

	private fun addMethod(requestData: RequestData, requestBuilder: Request.Builder) {
		when (requestData.method) {
			HttpMethod.GET -> requestBuilder.get()
			HttpMethod.POST -> requestBuilder.post(createRequestBody(requestData.body))
			HttpMethod.DELETE -> requestBuilder.delete()
			HttpMethod.PUT -> requestBuilder.put(createRequestBody(requestData.body))
			HttpMethod.PATCH -> requestBuilder.patch(createRequestBody(requestData.body))
			HttpMethod.HEAD -> requestBuilder.head()
		}
	}

	private fun createRequestBody(body: String?): RequestBody {
		val mediaType = "application/json; charset=utf-8".toMediaTypeOrNull()
		return RequestBody.create(mediaType, body ?: "")
	}

	private fun parseAuthorizationHeader(responseData: Response) {
		Session.authorizationValue = responseData.header(AUTHORIZATION_HEADER)
	}
}