# language: es

Característica: Escenarios de caja

  @CotizacionCaja @estable @retests
  Esquema del escenario:  Realizar cotizacion desde caja
    Dado que un cliente "<cliente>" realiza una compra y selecciona documento "<tipo_id>"
    Cuando selecciona "<convenio>" convenio y agrega el vendedor y el asesor
    Y agrega "<cantidad>" productos de tipo "<producto>"
    Y desea realizar el pago "<donacion>" donacion con metodo de pago "<metodo_pago>"
    Entonces deberia generarse la factura de pago
    Ejemplos:
      | cliente    | tipo_id | convenio | cantidad | producto | donacion | metodo_pago |
      | registrado | RUT     | NA       | 3        | dos      | sin      | efectivo    |
      #| registrado | NITPN   | NA       | 3        | dos      | sin      | efectivo    |





