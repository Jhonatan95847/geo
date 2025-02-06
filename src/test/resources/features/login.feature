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
      | registrado | PPT     | sin      | 3        | normal   | sin      | efectivo    |
      | registrado | NIT     | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | CC      | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | PAS     | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | PEP     | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | TI      | NA       | 3        | normal  | sin      | efectivo    |
      | registrado | NIUP    | NA       | 3        | normal  | sin      | efectivo    |
      | registrado | CE      | NA       | 3        | normal  | sin      | efectivo    |
      | registrado | DE      | NA       | 3        | normal  | sin      | efectivo    |
      | registrado | PPT     | sin      | 3        | normal  | con      | efectivo    |
      | registrado | NIT     | sin      | 3        | normal  | con      | efectivo    |
      | registrado | CC      | sin      | 3        | normal  | con      | efectivo    |
      | registrado | PAS     | sin      | 3        | normal  | con      | efectivo    |
      | registrado | PEP     | sin      | 3        | normal  | con      | efectivo    |
      | registrado | TI      | NA       | 3        | normal  | con      | efectivo    |
      | registrado | NIUP    | NA       | 3        | normal  | con      | efectivo    |
      | registrado | CE      | NA       | 3        | normal  | con      | efectivo    |
      | registrado | DE      | NA       | 3        | normal  | con      | efectivo    |
      | registrado | PPT     | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | NIT     | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | CC      | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | PAS     | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | PEP     | sin      | 3        | normal  | sin      | efectivo    |
      | registrado | TI      | NA       | 3        | normal  | sin      | efectivo    |
      | registrado | NIUP    | NA       | 3        | normal  | sin      | efectivo    |
      | registrado | CE      | NA       | 3        | normal  | sin      | efectivo    |
      | registrado | DE      | NA       | 3        | normal  | sin      | efectivo    |
      | registrado | PPT     | sin      | 3        | normal  | con      | efectivo    |
      | registrado | NIT     | sin      | 3        | normal  | con      | efectivo    |
      | registrado | CC      | sin      | 3        | normal  | con      | efectivo    |
      | registrado | PAS     | sin      | 3        | normal  | con      | efectivo    |
      | registrado | PEP     | sin      | 3        | normal  | con      | efectivo    |
      | registrado | TI      | NA       | 3        | normal  | con      | efectivo    |
      | registrado | NIUP    | NA       | 3        | normal  | con      | efectivo    |
      | registrado | CE      | NA       | 3        | normal  | con      | efectivo    |
      | registrado | DE      | NA       | 3        | normal  | con      | efectivo    |
      | nuevo      | CC      | sin      | 3        | normal  | con      | efectivo    |
      #| nuevo      | NIT     | sin      | 3        | normal  | sin      | efectivo    |
      #| nuevo      | CC      | sin      | 3        | normal  | sin      | efectivo    |
      #| nuevo      | PAS     | sin      | 3        | normal  | sin      | efectivo    |
      #| nuevo      | PEP     | sin      | 3        | normal  | sin      | efectivo    |
      #| nuevo      | TI      | NA       | 3        | normal  | sin      | efectivo    |
      #| nuevo      | NIUP    | NA       | 3        | normal  | sin      | efectivo    |
      #| nuevo      | CE      | NA       | 3        | normal  | sin      | efectivo    |
      #| nuevo      | DE      | NA       | 3        | normal  | sin      | efectivo    |
      #| registrado | PPT     | sin      | 3        | normal  | con      | efectivo    |
      #| registrado | NIT     | sin      | 3        | normal  | con      | efectivo    |
      #| registrado | CC      | sin      | 3        | normal  | con      | efectivo    |
      #| registrado | PAS     | sin      | 3        | normal  | con      | efectivo    |
      #| registrado | PEP     | sin      | 3        | normal  | con      | efectivo    |
      #| registrado | TI      | NA       | 3        | normal  | con      | efectivo    |
      #| registrado | NIUP    | NA       | 3        | normal  | con      | efectivo    |
      #| registrado | CE      | NA       | 3        | normal  | con      | efectivo    |
      #| registrado | DE      | NA       | 3        | normal  | con      | efectivo    |
      #| nuevo      | PPT     | sin      | 3        | normal  | con      | efectivo    |
      #| nuevo      | NIT     | sin      | 3        | normal  | con      | efectivo    |
      #| nuevo      | CC      | sin      | 3        | normal  | con      | efectivo    |
      #| nuevo      | PAS     | sin      | 3        | normal  | con      | efectivo    |
      #| nuevo      | PEP     | sin      | 3        | normal  | con      | efectivo    |
      #| nuevo      | TI      | NA       | 3        | normal  | con      | efectivo    |
      #| nuevo      | NIUP    | NA       | 3        | normal  | con      | efectivo    |
      #| nuevo      | CE      | NA       | 3        | normal  | con      | efectivo    |
      #| nuevo      | DE      | NA       | 3        | normal  | con      | efectivo    |


      #| nuevo      | CC      | sin      | 3        | normal  | sin      | efectivo    |
      #| nuevo      | CC      | sin      | 3        | normal  | sin      | efectivo    |
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



