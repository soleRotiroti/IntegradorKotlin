import java.util.*



fun main(args: Array<String>) {

    val car = Vehicle ("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CAR_001")
    val moto = Vehicle ("B222BBB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus = Vehicle ("CC333CC", VehicleType.MINIBUS, Calendar.getInstance())
    val bus = Vehicle ("DD444DD", VehicleType.BUS, Calendar.getInstance(), "DISCORD_CARD_002" )

    val parking = Parking (mutableSetOf(car, moto, minibus, bus))

    val car2 = Vehicle ("EE111EE", VehicleType.CAR, Calendar.getInstance())
    val moto2 = Vehicle ("FF222FF", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus2 = Vehicle ("GG333GG", VehicleType.MINIBUS, Calendar.getInstance())
    val bus2 = Vehicle ("HH444HH", VehicleType.BUS, Calendar.getInstance() )


    val vehicles = listOf(car2, moto2, minibus2, bus2)

    vehicles.forEach {
        parking.addVehicle(it)
        println (parking.message(it))
    }



}






