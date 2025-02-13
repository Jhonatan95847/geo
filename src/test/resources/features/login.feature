# language: es

Característica: Escenarios de caja

  @CotizacionCaja @estable @retests
  Esquema del escenario:  Realizar transaccion de ventas de caja manual
    Dado que un cliente "<cliente>" realiza una compra y selecciona documento "<tipo_id>"
    Cuando selecciona "<convenio>" convenio y agrega el vendedor y el asesor
    Y agrega "<cantidad>" productos de tipo "<producto>"
    Y desea realizar el pago "<donacion>" donacion con metodo de pago "<metodo_pago>"
    Entonces deberia generarse la factura de pago
    Ejemplos:
      | cliente    | tipo_id | convenio | cantidad | producto | donacion | metodo_pago |
      | registrado | NIT     | sin      | 3        | dos     | sin      | efectivo    |
      | registrado | CC      | sin      | 3        | dos     | sin      | efectivo    |
      | registrado | PAS     | sin      | 3        | dos     | sin      | efectivo    |
      | registrado | PEP     | sin      | 3        | dos     | sin      | efectivo    |
      | registrado | TI      | NA       | 3        | dos     | sin      | efectivo    |
      | registrado | NIUP    | NA       | 3        | dos     | sin      | efectivo    |





  @Redeban
  Esquema del escenario:  Realizar transaccion de ventas de caja manual
    Dado que un cliente "<cliente>" realiza una compra y selecciona documento "<tipo_id>"
    Cuando selecciona "<convenio>" convenio y agrega el vendedor y el asesor
    Y agrega "<cantidad>" productos de tipo "<producto>"
    Y desea realizar el pago "<donacion>" donacion con tarjeta "<tarjeta>" de la franquicia "<franquicia>"
    Entonces deberia generarse la factura de pago
    Ejemplos:
      | cliente    | tipo_id | convenio | cantidad | producto | donacion | tarjeta | franquicia |
      | registrado | NIT     | sin      | 3        | dos      |  sin     | credito | Mastercard |
      | registrado | CC      | sin      | 3        | dos      |  sin     | debito  | Mastercard |
      | registrado | CC      | sin      | 3        | dos      |  sin     | EL      | Mastercard |
      | registrado | CC      | sin      | 3        | dos      |  sin     | CC      | Mastercard |
      | registrado | CC      | sin      | 3        | dos      |  sin     | AH      | Mastercard |
      | registrado | CC      | sin      | 3        | dos      |  sin     | credito | Visa       |
      | registrado | CC      | sin      | 3        | dos      |  sin     | debito  | Visa       |
      | registrado | CC      | sin      | 3        | dos      |  sin     | EL      | Visa       |
      | registrado | CC      | sin      | 3        | dos      |  sin     | CC      | Visa       |
      | registrado | CC      | sin      | 3        | dos      |  sin     | AH      | Visa       |







