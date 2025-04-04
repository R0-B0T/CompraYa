@afiliacionFisico
Feature: Validar afiliación de un Producto fisico con Punto web

  Scenario Outline: El usuario realiza la compra de un POS Fisico
    Given que el usuario ingresa a la página de Compraya
    When el usuario selecciona el producto "<producto>"
    And el usuario elige el tipo de documento "<tipo_documento>"
    And el usuario elige el documento  "<documento>"
    And el usuario ingresa el "<RUC>" como número de RUC y el "<n_documento>" como número de documento
    And el usuario ingresa "<nombre>" como "<apellidoPat>" y "<apellidoMat>"



    Examples:
      | producto          | tipo_documento | documento | n_documento | RUC         | nombre | apellidoPat | apellidoMat |
      | POS android P2 SE | RUC            | DNI       | 47868997    | 10469737816 |        |             |             |
       #| POS android P2 SE | RUC            | CE        | 47568900    | 10428822521 |  Pepe  | Alvarez     | Ramos       |
       #| POS android P2 SE | DNI/CE         | DNI       | 47868997    |             |        |             |             |
       #| POS android P2 SE | DNI/E         | CE        | 00000211471 |             |        |             |             |