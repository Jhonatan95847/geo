# language: es

Característica: Escenarios de caja

  @CotizacionCaja @estable @retests
  Escenario:  Realizar cotizacion desde caja
    Dado que un usuario ingresa a la caja y selecciona tipo de documento "<C>"
    #Cuando ingresa el numero de ID del cliente y selecciona "<convenio>" convenio
    #Y agrega "<n>" cantidad de productos de tipo "<kasados>"
    #Y desea realizar el pago "<sin>" donacion con metodo de pago "<efectivo>" y juega la ruleta
    #Entonces deberia generarse la factura de pago
    #Ejemplos:
      #| documento | convenio | n | kasados | sin | efectivo |