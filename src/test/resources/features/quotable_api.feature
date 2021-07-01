@quotableAPI
Feature: QuotableAPI - Automation
  I want to automate the QuotableAPI and validate the various functionalities

  Background: 
    Given the api is composed of "https://api.quotable.io/"

  @quotableAPIWithPathParameters
  Scenario Outline: Test quotable api with various pathparam
    Given A call to quotable api with pathparm "<pathparam>"
    And response code should be "200"

    Examples: 
      | pathparam |
      | quotes    |
      | authors   |
      | tags      |
