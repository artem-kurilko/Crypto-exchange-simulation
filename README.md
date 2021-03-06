# Crypto market simulation 

This program simulates crypto exchange, getting current order book from Binance exchange and matching it with user's active orders.
If your price and quantity matches any of order book it can be executed fully or partially.

``Base url: localhost:8080``

## Market simulation API: 

### Создание пользователя
``POST /user``

**Необходимые параметры запроса:**
* userId - идентификатор пользователя, тип Long
* name - имя пользователя, тип String 
* btcBalance - баланс биткоина, тип float
* usdtBalance - баланс usdt, тип float

### Получить информацию о пользователе

``GET /user``

**Необходимые параметры запроса:**
* userId - идентификатор пользователя, тип Long

### Баланс пользователя

####Получить свободный баланс биткоина

``GET /balance/btc/free``

####Получить зарезервированный баланс биткоина

``GET /balance/btc/reserved``

####Получить свободный usdt баланс

``GET /balance/usdt/free``

####Получить зарезервированный usdt баланс

``GET /balance/usdt/reserved``

**Необходимые параметры запроса:**
* userId - идентификатор пользователя, тип Long

### Разместить ордер

``POST /order``

**Необходимые параметры запроса:**
* userId - идентификатор пользователя, тип Long
* isBuy - если ордер на покупку, тип boolean
* side - сторона ордер (buy/sell), тип string
* price - цена, тип string 
* quantity - количество, тип string

### Отменить ордер

``DELETE /order``

**Необходимые параметры запроса:**
* userId - идентификатор пользователя, тип Long
* orderId - идентификатор ордера, тип Long

### Получить активные ордера пользователя

``GET /order``

**Необходимые параметры запроса:**
* userId - идентификатор пользователя, тип Long

### Получить выполненные ордера пользователя

``GET /ordersHistory``

**Необходимые параметры запроса:**
* userId - идентификатор пользователя, тип Long
