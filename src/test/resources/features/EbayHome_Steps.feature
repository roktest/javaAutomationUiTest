@Ebay
Feature: Ebay home page Scenarios

  @Test1
  Scenario: As user I want to go to advance search from Ebay home page
    Given I am on Ebay home page
    When I click on Advanced search
    Then I navigate to Advanced search page

  @p1 @iphone11 @setCookies @unsetCookies
  Scenario: As user I want to go to search for iphone 11 on Ebay home page
    Given I am on Ebay home page
    When I search for 'iphone 11' on Ebay home page
    Then I validate at least 5000 search items present

  @p1 @toyCars @setCookies
  Scenario: As user I want to go to search for iphone 11 on Ebay home page
    Given I am on Ebay home page
    When I search for 'toy cars' on Ebay home page
    Then I validate at least 10 search items present

  @p1 @babySoap @setCookies
  Scenario: As user I want to search for an item on a given category on Ebay home page
    Given I am on Ebay home page
    When I search for 'Jabón', on 'Bebés' category on Ebay home page
    Then I validate at least 10 search items present

  @navigationMenuDataTable
  Scenario Outline: As user I want to click each available menu of the Ebay home page and validate if the page title is ok
    Given I am on Ebay home page
    When I click on navigation bar '<navBarOption>' of the Ebay home page
    Then I want validate if the page navigates to '<expectedUrl>' and that page title '<expectedPageTitle>' changes accordingly

    Examples:
      | navBarOption          | expectedUrl                                                       | expectedPageTitle              |
      | Tecnología            | https://ar.ebay.com/b/Electronics/bn_7000259124                   | Electronics                    |
      | Vehículos             | https://ar.ebay.com/b/Auto-Parts-Accessories/6028/bn_569479       | Auto PARTS                     |
      | Moda                  | https://ar.ebay.com/b/Clothing-Shoes-Accessories/11450/bn_1852545 | Ropa, Calzado y Accesorios     |
      | Coleccionables y Arte | https://ar.ebay.com/b/Collectibles-Art/bn_7000259855              | colección y arte               |
      | Deportes              | https://ar.ebay.com/b/Sporting-Goods/888/bn_1865031               | Artículos deportivos           |
      | Salud y Belleza       | https://ar.ebay.com/b/Health-Beauty/26395/bn_1865479              | Salud y belleza                |
      | Equipo industrial     | https://ar.ebay.com/b/Business-Industrial/12576/bn_1853744        | Equipo y maquinaria industrial |
      | Hogar y Jardín        | https://ar.ebay.com/b/Home-Garden/11700/bn_1853126                | Home & Garden                  |
      | Ofertas               | https://www.ebay.com/globaldeals                                  | Daily Deals                    |
      | Vender                | https://www.ebay.com/sl/sell                                      | Selling                        |

