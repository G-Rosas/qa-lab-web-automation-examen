@teststore
Feature: Product - Store


  Scenario: : Validación del Precio de un Producto con datos válidos
    Given estoy en la página de la tienda
    And me logueo con mi usuario "<usuario>" y clave "<clave>"
    When navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    And agrego "2" unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado: "Producto añadido correctamente a su carrito de compra"
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el título de la página del carrito: "CARRITO"
    And vuelvo a validar el cálculo de precios en el carrito
    Examples:
      | usuario                  | clave     | categoria | subcategoria |
      | giancarlorosas@gmail.com | Gin55tfG! | Clothes   | Men          |
      | giancarlorosas@gmail.com | Gin55tfG! | Autos     | Cars         |

  Scenario: Validación del login con datos inválidos
    Given estoy en la página de la tienda
    When me logueo con mi usuario "<usuario>" y clave "<clave>"
    Then el sistema valida el mensaje de: "Error de autenticación."
    Examples:
      | usuario                  | clave         | categoria | subcategoria |
      | giancarlorosas@gmail.com | IncorrectPass | Clothes   | Men          |

