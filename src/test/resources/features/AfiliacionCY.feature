@afiliacionFisico
Feature: Validar afiliación de un Producto fisico con Punto web

  Scenario Outline: El usuario realiza la compra de un POS Fisico
    Given que el usuario ingresa a la página de Compraya
    When el usuario selecciona el producto "<producto>"
    And el usuario elige el tipo de documento "<tipoDocumento>"
    And el usuario elige el documento  "<documento>"
    And el usuario ingresa el "<RUC>" como número de RUC y el "<nDocumento>" como número de documento
    And el usuario ingresa el "<nombres>"


    Examples:
      | producto          | tipoDocumento | documento | nDocumento    | RUC         | nombres |
      | POS android P2 SE | RUC           | CE        | 00000211471   | 10469737816 |  manuel |