@LibroReclamaciones
  Feature: Registro de reclamos en el Libro de Reclamaciones

    Background:
      Given El usuario se encuentra en la página del Libro de Reclamaciones

    @Comercio_afiliado
    Scenario Outline: Registro de reclamo con comercio afiliado
      Given que el usuario navega a la página de IZIVENDO
      When ingresa su usuario "<usuario>"
      And coloca su clave "<clave>"

      Examples:
      | usuario   | clave           | categoria| tarjeta| cupon|correo| celular |
      #| qa_dealer | CompraYa202411|||||