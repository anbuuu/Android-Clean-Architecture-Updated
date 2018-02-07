# Fairfax Coding Exercise for Android

Android Coding Exercise for showing the List of News Articles and clicking on the item will take the User to the Detailed News Section.

## Getting Started

This repository contains a detailed sample App which consumes the given API and displays a list of news articles to the user. App implements MVP Architecture using Dagger2, RxJava, Retrofit2, Butter Knife, Stetho, Event Bus, Espresso, Mockito and Material Design

### Prerequisites - Development

Android Studio 3.0, Gradle, Build Tools Version >= 25.0.2

### App Supported Devices

From Android Minimum SDK Version 19 / Android 4.4 (KITKAT)

### Installing

A Dropbox link is provided is below, which can be used to download the APK and installing on the physical device, following instructions ( Additonal step is to "Enable Third Party Apps Installation" on Device )

https://www.dropbox.com/s/pe28u2aflp1gbqe/FairfaxCodingChallenge.apk?dl=0

### Overview 

<p align="center">
  
 <img src="https://github.com/anbuuu/fairfaxpictures/blob/master/App%20Landing%20Page.png" width="250">
 <img src="https://github.com/anbuuu/fairfaxpictures/blob/master/App%20Detailed%20-%20Webview.png" width="250">

 
</p>


### Architecture Blue Print

Implemented the project with Clean Architecture ( Bob ). I had chosen this one for the implementation which is Indepdnent of Frameworks, Each component individually testable, Independent of UI and any external agency.  Borrowing from Bob's Clean Architecture Diagram as below : 

<img src="https://github.com/anbuuu/fairfaxpictures/blob/master/Clean%20Architecture%20Bob.png" width="400" height="250"/>

The main dependency rule is that source code dependencies can only point inwards and nothing in an inner circle know anything about something in the outer circle. 

<img src="https://github.com/anbuuu/fairfaxpictures/blob/master/Bobs-Implementation.png" width="300" height="250" />

To achieve the separation of concerns, I designed to break up the project into 3 different layers which are 
 * Presentation layer
 * Domain layer and
 * Data layer

<img src="https://github.com/anbuuu/fairfaxpictures/blob/master/Multiple-Layers.png" width="300" height="250" />

## Presentation Layer

This is an android module that represents the presentation layer. The layer implements logic related with views and animations. It uses MVP. This project primarily uses a Single Activity ( ```AppMainActivity ``` ) and 2 Fragments, one for the App List View and another for the Web View for the selected News Article. 

## Domain layer

<img src="https://github.com/anbuuu/fairfaxpictures/blob/master/Domain-layer.png" width="300" height="250" />


This layer provides interactors and the corresponding implementations as well. The business rules is implemented here, and this layer is purely a java model without any android dependencies. 

The project has an Abstract method for Interactors which utilisex RxJava Subscription and Observable to interact and implement. The model classes are POJO.

## Data Layer

<img src="https://github.com/anbuuu/fairfaxpictures/blob/master/Data%20Implementation.png" width="500" height="400" />

The data needed for the application comes from this layer through the ```DataRepository``` implementation with the interface in Domain layer. The idea behind is that data origin is transparent to the client.

### Project Structure

<img src="https://github.com/anbuuu/fairfaxpictures/blob/master/App-Structure.png" width="400" height="300" />

### Unit Tests 

Unit tests covering Service API Calls, Recycler Items Loading, Scrolling to a certain position, Validation of Items and Click event on News Articles

## Libraries Used

* [RxJava](http://www.dropwizard.io/1.0.2/docs/) - Open Source Implementation of ReactiveX
* [Dagger](https://google.github.io/dagger/) - Dependency Injection Framework
* [Retrofit2](http://square.github.io/retrofit/) - HTTP Client for Android and Java
* [ButterKnife](http://jakewharton.github.io/butterknife/) - Bind Library for Android Views
* [Mockito](http://site.mockito.org/) - Unit Testing Framework
* [Espresso](https://developer.android.com/training/testing/espresso/index.html) - UI Testing Framework





## Versioning

Demo Version

## Author

* **Anbu Ezhilan** - (https://github.com/anbuuu)

