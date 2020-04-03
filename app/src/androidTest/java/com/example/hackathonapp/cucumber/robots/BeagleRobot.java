package com.example.hackathonapp.cucumber.robots;

import com.example.hackathonapp.common.ScreenRobot;
import com.example.hackathonapp.cucumber.elements.*;


public class BeagleRobot extends ScreenRobot<BeagleRobot> {


    public BeagleRobot validateLoginScreen() {
//        checkViewContainsText("User");
        checkViewContainsText("Entrar");
        return this;
    }

    public BeagleRobot insertLogin() {
        enterTextIntoView(BeagleElements.LOGIN_FIELD, "loginBeagle");
        closeKeyboard();
        return this;
    }

    public BeagleRobot chooseOption(String optionText) {
        clickOnListWithText(optionText);
        return this;
    }

    public BeagleRobot checkCoffeeIsDisplayed(String nome, String valor, String texto) {
        checkTextIsDisplayed(BeagleElements.SCROLL_SCREEN, nome);
        checkTextIsDisplayed(BeagleElements.SCROLL_SCREEN, valor);
        checkTextIsDisplayed(BeagleElements.SCROLL_SCREEN, texto);
        return this;
    }

    public BeagleRobot headerIsPresented(String selectedOption) {
        checkIdHasText(BeagleElements.SELECTED_SCREEN_HEADER, selectedOption);
        return this;
    }

    public BeagleRobot buttonIsDisplayed(String optionText){
        checkViewContainsText(optionText);
        return this;
    }

    public BeagleRobot validateCoffeeDisplayScreen(){

//        checkIsDisplayed(BeagleElements.CHECKOUT_CART);

        checkViewContainsText(BeagleElements.COFFEE_DISPLAY_PAGE_TITLE);
        checkViewContainsText(BeagleElements.HEADER_TEXT);
        checkViewContainsText(BeagleElements.SUBHEADER_TEXT);

        checkViewContainsText(BeagleElements.COFFEE_TEXT_1);
        checkViewContainsText(BeagleElements.COFFEE_SUBTEXT_1);
        checkViewContainsText(BeagleElements.COFFEE_PRICE_1);

        checkViewContainsText(BeagleElements.COFFEE_TEXT_2);
        checkViewContainsText(BeagleElements.COFFEE_SUBTEXT_2);
        checkViewContainsText(BeagleElements.COFFEE_PRICE_2);

        checkViewContainsText(BeagleElements.COFFEE_TEXT_3);
        checkViewContainsText(BeagleElements.COFFEE_SUBTEXT_3);
        checkViewContainsText(BeagleElements.COFFEE_PRICE_3);

        checkViewContainsText(BeagleElements.COFFEE_TEXT_4);
        checkViewContainsText(BeagleElements.COFFEE_SUBTEXT_4);
        checkViewContainsText(BeagleElements.COFFEE_PRICE_4);

        scrollViewDown(BeagleElements.SCROLL_SCREEN);

        checkViewContainsText(BeagleElements.COFFEE_TEXT_5);
        checkViewContainsText(BeagleElements.COFFEE_TEXT_5);
        checkViewContainsText(BeagleElements.COFFEE_TEXT_5);

        checkViewContainsText(BeagleElements.COFFEE_TEXT_6);
        checkViewContainsText(BeagleElements.COFFEE_TEXT_6);
        checkViewContainsText(BeagleElements.COFFEE_TEXT_6);

        checkViewContainsText(BeagleElements.COFFEE_TEXT_7);
        checkViewContainsText(BeagleElements.COFFEE_TEXT_7);
        checkViewContainsText(BeagleElements.COFFEE_TEXT_7);

        checkViewContainsText(BeagleElements.COFFEE_TEXT_8);
        checkViewContainsText(BeagleElements.COFFEE_TEXT_8);
        checkViewContainsText(BeagleElements.COFFEE_TEXT_8);

        return this;
    }

    public BeagleRobot checkoutCart() {
        clickOnId(BeagleElements.CHECKOUT_CART);
        return this;
    }

}