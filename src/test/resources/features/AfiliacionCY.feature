@afiliacionFisico
Feature: Validar afiliación de un Producto fisico con Punto web

  Scenario Outline: El usuario realiza la compra de un POS Fisico
    Given que el usuario ingresa a la página de Compraya
    When el usuario selecciona el producto "<producto>"




    Examples:
      | producto          |
      | POS android P2 SE3 |