Feature: A user should be able to add a specific women's summer dress and remove from shopping basket

   Scenario: Add and remove a womens summer dress to shopping basket
      Given There is a women summer dress
         And Dresses are sorted by price
      When Item number "0" is added to basket
      Then A dress should be in basket
      When User removed item from shopping cart
      Then There should not be a dress in basket

   Scenario: Add another womens summer dress to shopping basket
      Given There is a women summer dress
      When Item number "1" is added to basket
      Then A dress should be in basket