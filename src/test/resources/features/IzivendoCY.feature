@Izivendo
Feature: Generación de la tarjeta personalizada en izivendo

  Scenario Outline: Validar la generación de una tarjeta personalizada
    Given que el usuario navega a la página de IZIVENDO
    When ingresa su usuario "<usuario>"
    And coloca su clave "<clave>"
    And presiona el botón Ingresar
    And selecciona la categoría "<categoria>"
    And selecciona la tarjeta "<tarjeta>"
    And escribe el nombre del cupon "<cupon>"
    And escribe el correo "<correo>"
    And escribe el celular "<celular>"
    And selecciona el boton Grabar diseño




    Examples:
      | usuario   | clave           | categoria| tarjeta| cupon|correo| celular |
      #| qa_dealer | CompraYa202411|||||
      #| qa_call   | CompraYa2024$1  | TPP||||
      #| qa_call   | CompraYa2024$1  | Comercial QA| prueba|||
      #| qa_call   | CompraYa2024$1  | Comercial QA| arisale|||
      #| qa_call   | CompraYa2024$1  | Comercial QA| test| ABC0001||
      #| qa_call   | CompraYa2024$1  | Comercial QA| test| IZIZENTROECOS||
      #| qa_call   | CompraYa2024$1  | Comercial QA| test| IZITECHJJUAREZ||
      #| qa_call   | CompraYa2024$1  | Comercial QA| test| ANDROID72739390||
      | qa_call   | CompraYa2024$1  | Comercial QA| test| |||

