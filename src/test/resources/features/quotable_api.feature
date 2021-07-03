@quotableAPI
Feature: QuotableAPI - Automation
  I want to automate the QuotableAPI and validate the various functionalities

  Background: 
    Given the api is composed of "https://api.quotable.io/"

  @quotableAPIWithPathParameters
  Scenario Outline: Test quotable api with various pathparam
    Given A call to quotable api with pathparm "<pathparam>"
    When response code is "200"
    Then validate the total count "<totalCount>"

    Examples: 
      | pathparam | totalCount |
      | quotes    |       1885 |
      | authors   |        700 |

  @quotableAPIWithSingleQueryParameter
  Scenario Outline: Test_quotable_api_with_various_single_queryparam
    Given A call to quotable api with path as "<path>"
    Then validate the api with following queryparams
      | query          | value      |
      | <queryParam>   | <tagValue> |
    When response code is "200"

    Examples: 
      | path    | queryParam | tagValue                       |
      | random  | maxLength  |       50                       |
      | random  | tags       | history,civil-rights           |
      | quotes  | tags       | love,happiness                 |
      | quotes  | author     | albert-einstein                |
      | authors | sortBy     | name                           |
      | authors | slug       | albert-einstein,abraham-lincoln|
      | authors | id         | 8ry084PzfT                     |
      

  @quotableAPIWithTagsAndQuotesParam
  Scenario Outline: Test_quotable_api_with_tags_quotes_queryparams
    Given A call to quotable api with path as "<path>"
    Then validate the api with following multiple queryparams
      | property   | value           |
      | tags       | <tagValue>      |
      | author     | <authorValue>   |
    When response code is "200"
    Then validate the total count "<totalCount>"

    Examples: 
    | path   |tagValue                 | authorValue|totalCount |
    | quotes |famous-quotes,wisdom     | Confucius  | 40        |
    
    
    @quotableAPIWithTagsAndPagesParam
  Scenario Outline: Test_quotable_api_with_tags_pages_queryparams
    Given A call to quotable api with path as "<path>"
    Then validate the api with following multiple queryparams
      | property   | value         |
      | tags       | <tagValue>    |
      | page       | <pageValue>   |
    When response code is "200"
    Then validate the total count "<totalCount>"

    Examples: 
    | path   |tagValue       | pageValue|totalCount |
    | quotes |friendship     | 2        | 187        |
    
    @quotableAPIWithTagsPagesAuthorParam
  Scenario Outline: Test_quotable_api_with_tags_pages_author_queryparams
    Given A call to quotable api with path as "<path>"
    Then validate the api with following multiple queryparams
      | property   | value         |
      | tags       | <tagValue>    |
      | page       | <pageValue>   |
      | author     | <authorValue> |
    When response code is "200"
    Then validate the total count "<totalCount>"

    Examples: 
    | path   |tagValue       | pageValue|authorValue|totalCount |
    | quotes |friendship     | 1        |Mencius    |2          |
    
 