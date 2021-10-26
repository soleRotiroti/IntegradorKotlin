data class ParkingSpace (val vehicle: Vehicle){

    val parking = Parking(mutableSetOf())

    fun checkOutVehicle(plate: String, onSuccess: (Int)-> Unit, onError: ()->Unit){
        val vehicle = searchVehicle(plate).let {
            onSuccess
        } ?: run(onError)
    }

    fun searchVehicle(plate: String): Vehicle? {

        for (vehicle in parking.vehicles){
            if (plate.equals(vehicle.plate))
                return vehicle
        }
        return null
    }

    fun removeVehicle (vehicle: Vehicle){
        parking.vehicles.remove(vehicle)
    }


}
