package com.example.hackathonapp.cucumber.steps;

import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import com.example.hackathonapp.feature.splash.SplashActivity;
import com.example.hackathonapp.cucumber.robots.BeagleRobot;
import com.example.hackathonapp.cucumber.elements.*;

import com.example.hackathonapp.util.ActivityFinisher2;

import org.junit.Rule;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.*;


public class BeagleSteps {

    @Rule
    public ActivityTestRule<SplashActivity> activityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Before("@beagle")
    public void setup() {
        activityTestRule.launchActivity(new Intent());
    }

    @After("@beagle")
    public void tearDown() {
        ActivityFinisher2.finishOpenActivities();
    }


    @Dado("^que o usuario esteja na tela principal$")
    public void main_screen() throws InterruptedException {
        new BeagleRobot()
                .sleep(5)
                .validateLoginScreen();
    }

    @E("^o usuario inserir o login de acesso$")
    public void insert_login() {
        new BeagleRobot()
                .insertLogin();
    }

    @E("^o usuario clicar na opcao (.*)$")
    public void click_on_option(final String optionText) throws InterruptedException {
        new BeagleRobot()
                .sleep(2)
                .chooseOption(optionText)
                .sleep(5);
    }

    @Quando("^usuario realizar um scroll na tela$")
    public void click_on_option() throws InterruptedException {
        new BeagleRobot()
                .sleep(2)
                .scrollViewDown(BeagleElements.SCROLL_SCREEN);
    }

    @E("^a tela com o header (.*) e devidamente apresentada$")
    public void selected_screen_display(final String selectedOption) throws InterruptedException {
        new BeagleRobot()
                .sleep(1)
                .headerIsPresented(selectedOption);
    }

    @E("^o botao (.*) e apresentado$")
    public void button_is_displayed(final String optionText){
        new BeagleRobot()
                .buttonIsDisplayed(optionText);
    }

    @E("^a mensagem (.*) e apresentada$")
    public void message_is_displayed(final String optionText) {
        new BeagleRobot()
                .buttonIsDisplayed(optionText);
    }

    @Entao("^o cafe e adicionado com sucesso ao carrinho$")
    public void coffee_is_added_to_checkout_cart() {
        new BeagleRobot()
                .clickOnBackButton(BeagleElements.BACK_BUTTON)
                .checkoutCart();
        //Check items exist
    }

    @Entao("^tela de exibicao de cafes e visualizada com sucesso$")
    public void coffee_display_screen() throws InterruptedException {
        new BeagleRobot()
                .sleep(15)
                .validateCoffeeDisplayScreen();
    }

    @Entao("^a tela e apresentada com o nome (.*), valor (.*) e texto (.*)$")
    public void checkout_cart(String nome, String valor, String texto){
        new BeagleRobot()
                .checkCoffeeIsDisplayed(nome, valor, texto);
    }
}