@Izivendo
Feature: Portal Izivendo

  Scenario Outline: Izivendo tarjeta personalizada
    Given que el usuario navega a la página de IZIVENDO
    When ingresa su usuario "<usuario>"
    And coloca su clave "<clave>"
    And presiona el botón Ingresar
    And selecciona la categoría "<categoria>"
    And selecciona la tarjeta "<tarjeta>"
    And escribe el nombre del cupon "<cupon>"



    Examples:
      | usuario   | clave           | categoria| tarjeta|cupon|
      #| qa_dealer | CompraYa202411||
      | qa_call   | CompraYa2024$1  | Comercial QA|test|PROMOCALL|