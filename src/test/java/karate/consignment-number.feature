Feature: Consignment NUmber Generator Test

  Background:
    * def consignmentNumberUrl = baseUrl + 'api/v1/generate-cannote-number'

  Scenario: Generate Consignment Number
    Given url consignmentNumberUrl
    And request
    """
       {
        "carrierName":"FreightmateCourierCo",
        "accountNumber":"123ABC",
        "digits":10,
        "lastUsedIndex":19604,
        "rangeStart":19000,
        "rangeEnd":20000
      }
    """
    When method POST
    Then status 200
    And match response contains "FMCC123ABC00000196051"

  Scenario: Generate Consignment Number Bad Request
    Given url consignmentNumberUrl
    And request
    """
       {

      }
    """
    When method POST
    Then status 400
    And match response contains
    """
    [
       {
          "fieldName":"rangeStart",
          "errorMessage":"must not be null"
       },
       {
          "fieldName":"lastUsedIndex",
          "errorMessage":"must not be null"
       },
       {
          "fieldName":"accountNumber",
          "errorMessage":"must not be null"
       },
       {
          "fieldName":"digits",
          "errorMessage":"must not be null"
       },
       {
          "fieldName":"rangeEnd",
          "errorMessage":"must not be null"
       },
       {
          "fieldName":"carrierName",
          "errorMessage":"must not be null"
       }
    ]
    """





