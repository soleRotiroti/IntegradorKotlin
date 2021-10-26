
data class Parking(val vehicles: MutableSet<Vehicle>){

    val maxVehicles = 20

    fun addVehicle (vehicle: Vehicle): Boolean{
        if (vehicles.size<maxVehicles){
            vehicles.add(vehicle)
            return true
        }else return false
    }

    fun message (vehicle: Vehicle): String {
        return if(vehicles.contains(vehicle)) "Welcome to AlkeParking" else "Sorry, the has check-in failed"
    }


}