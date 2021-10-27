import java.util.*
import java.util.concurrent.TimeUnit


fun main(args: Array<String>) {

    val car = Vehicle ("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CAR_001")
    val moto = Vehicle ("B222BBB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus = Vehicle ("CC333CC", VehicleType.MINIBUS, Calendar.getInstance())
    val bus = Vehicle ("DD444DD", VehicleType.BUS, Calendar.getInstance(), "DISCORD_CARD_002" )

    val car2 = Vehicle ("EE111EE", VehicleType.CAR, Calendar.getInstance())
    val moto2 = Vehicle ("B2222BBB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus2 = Vehicle ("GG333GG", VehicleType.MINIBUS, Calendar.getInstance())
    val bus2 = Vehicle ("HH444HH", VehicleType.BUS, Calendar.getInstance() )


    var arrayVehicles = arrayOf<Vehicle>(car,moto,minibus,bus)
    var parking = Parking(mutableSetOf(),6)

    for(vehicle in arrayVehicles){
        parking.addVehicle(vehicle)
    }

    parking.removeVehicle(minibus)
    parking.getGain()
    parking.removeVehicle(bus)
    parking.getGain()

}

//Responder: ¿Por qué se define vehicles como un Set ?
// Recuerda en qué se diferencian los Set de los Array. ¿Podrían existir dos
//vehículos iguales?

//¿Puede cambiar el tipo de vehículo en el tiempo?
// ¿Debe definirse como variable o como constante en Vehicle?

//checkintime ¿Dónde deben agregarse las propiedades, en  ParkingSpace,  Vehicle o en ambos?
// La tarjeta de descuentos es opcional, es decir que un vehículo puede no tener una tarjeta y su valor será null.
// ¿Cómo indicamos que un tipo de datos puede adquirir esta característica en Kotlin?







