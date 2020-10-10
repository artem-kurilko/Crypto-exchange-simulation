### Crypto market simulation ###

This program shows real-time BTC-USDT price, also it simulates trades, using parsing open orders from HitBTC exchange.
If your price and quantity matches any of open orders it can be executed fully or partially.

Base url: localhost:8080

## Market simulation API: ##

GET /average-price
get average price, mandatory parameter string currency pair, return string

GET /open-orders
get open orders, return json array

POST /create
create new order, mandatory parameters string side(buy or sell), string quantity, string size, string currency pair

DELETE /delete
delete order, mandatory parameter string client order id

# This program supports such requests:
- get current average price
- get active orders
- get orders history
- place/cancel orders
- show market orders

You can use multi threads to test your parameters more efficiently.