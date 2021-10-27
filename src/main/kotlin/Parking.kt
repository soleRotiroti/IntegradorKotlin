data class Parking(val vehicles: MutableSet<Vehicle>, val maxVehicles: Int){

    private var earnings = 0
    private var lotVehicle = 0

    var pair: Pair<Int, Int> = Pair (0,0)

    fun addVehicle (vehicle: Vehicle): Boolean{
        if (vehicles.size<maxVehicles){

            val success = vehicles.add(vehicle)
            if (!success){
                println("Sorry, the has check-in failed")
                return false
            }
            println("Welcome to AlkeParking!")
            return true
        }

        println("Sorry, the check-in failed")
        return false
    }

    fun removeVehicle (vehicle: Vehicle){
        var parkingSpace = ParkingSpace(vehicle, vehicles)
        parkingSpace.checkOutVehicle(vehicle.plate,::onSucces, ::onError )
    }


    fun listVehicles(){
        for (v in vehicles){
            println(v.plate)
        }
    }

    fun onSucces(n: Int){
        earnings += + n
        lotVehicle += +1
        pair = Pair(lotVehicle, earnings)
        println("Your fee is:  $"+ n + ". Come back soon." )

    }

    fun onError(){
        println("Sorry, the check-out failed")
    }

    fun getGain() = println("${pair.first} vehicles have checked out and have earnings of ${pair.second}")


}