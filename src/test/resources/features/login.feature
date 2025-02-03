# language: es

Característica: Escenarios de caja

  @CotizacionCaja @estable @retests
  Esquema del escenario:  Realizar cotizacion desde caja
    Dado que un cliente "<cliente>" realiza una compra y selecciona documento "<tipo_id>"
    Cuando selecciona "<convenio>" convenio y agrega el vendedor y el asesor
    Y agrega "<cantidad>" productos de tipo "<kasados>"
    Y desea realizar el pago "<donacion>" donacion con metodo de pago "<metodo_pago>"Jhonatan

    #Entonces deberia generarse la factura de pago
    Ejemplos:
      | cliente    | tipo_id | convenio | cantidad | kasados | donacion | metodo_pago |
      | registrado | CC      | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | CC      | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | CC      | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | CC      | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | CC      | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | CC      | sin      | 3        | normal  | sin      | efectivo    |
      | nuevo      | CC      | sin      | 3        | normal  | sin      | efectivo    |
      | nuevo      | CC      | sin      | 3        | normal  | sin      | efectivo    |
      | nuevo      | CC      | sin      | 3        | normal  | sin      | efectivo    |
      | nuevo      | CC      | sin      | 3        | normal  | sin      | efectivo    |
      | nuevo      | CC      | sin      | 3        | normal  | sin      | efectivo    |
      #| registrado | TI      | sin      | 3        | normal  | sin      | efectivo    |
      #| registrado | NIUP    | sin      | 3        | normal  | sin      | efectivo    |
      #| registrado | PAS     | sin      | 3        | normal  | sin      | efectivo    |
      #| registrado | PEP     | sin      | 3        | normal  | sin      | efectivo    |
      #| registrado | CC      | sin      | 3        | normal  | con      | efectivo    |
      #| registrado | CE      | sin      | 3        | normal  | con      | efectivo    |
      #| registrado | NIT     | sin      | 3        | normal  | con      | efectivo    |
      #| registrado | RUT     | sin      | 3        | normal  | con      | efectivo    |
      #| registrado | TI      | sin      | 3        | normal  | con      | efectivo    |
      #| registrado | NIUP    | sin      | 3        | normal  | con      | efectivo    |
      #| registrado | PAS     | sin      | 3        | normal  | con      | efectivo    |
      #| registrado | PEP     | sin      | 3        | normal  | con      | efectivo    |



