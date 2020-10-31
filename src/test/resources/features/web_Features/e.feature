Feature:  Doc String Feature File Title

  @sanity
  Scenario: handling a Doc String
    Given a book "cucumber cookbook" with the following body
      """
        Title = Cucumber cookbook
        I am  the Author nd sending XML and JSON strings
        AS many xml as possible
      """

    @regression
    Scenario Outline: Verify Email sending
      Given I have a user with <role> rights
      Then I am sending you email with a body:
      """
        Dear Sir
        you have been granted <role> rights
        with <details> attached.
        Please be responsible
      """
      Examples:
      |role|details|
      |Manager|All permission|
      |Tester |All rights    |
      |developer|All rights  |