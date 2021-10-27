data class ParkingSpace (val vehicle: Vehicle, val listVehicles: MutableSet<Vehicle>){

    var costTotal:Int = 0

    fun checkOutVehicle(plate: String, onSuccess: (Int)-> Unit, onError: ()->Unit){

        val vehicleRemoved = searchVehicle(plate)

        vehicleRemoved?.let{
            val result = calculateFee(vehicleRemoved,vehicleRemoved.parkedTime)
            onSuccess(result)
            listVehicles.remove(vehicleRemoved)

        } ?: onError()
    }

    fun searchVehicle(plate: String): Vehicle? {
        for (vehicle in listVehicles){
            if (plate.equals(vehicle.plate))
                return vehicle
        }
        return null
    }

    fun calculateFee(vehicle: Vehicle, parkedTime: Long): Int {

        var hasDiscountCard:Boolean = false

        if(vehicle.discountCard!=null){
            hasDiscountCard = true
        }

        when (vehicle.type) {
            VehicleType.CAR -> {
                if (parkedTime in (0..120)) return 20
                else {
                    var timeTotal = (parkedTime.toDouble() - 120) / 15
                    var blocks = Math.ceil(timeTotal)
                    costTotal = 20 + (blocks.toInt() * 5)
                }

            }
            VehicleType.MOTORCYCLE -> {
                if (parkedTime in (0..120)) return 15
                else {
                    var timeTotal = (parkedTime.toDouble() - 120) / 15
                    var blocks = Math.ceil(timeTotal)
                    costTotal = 15 + (blocks.toInt() * 5)
                }

            }

            VehicleType.MINIBUS -> {
                if (parkedTime in (0..120)) return VehicleType.MINIBUS.rate
                else {
                    var timeTotal = (parkedTime.toDouble() - 120) / 15
                    var blocks = Math.ceil(timeTotal)
                    costTotal = 25 + (blocks.toInt() * 5)
                }

            }

            VehicleType.BUS -> {
                if (parkedTime in (0..120)) return 30
                else {
                    var timeTotal = (parkedTime.toDouble() - 120) / 15
                    var blocks = Math.ceil(timeTotal)
                    costTotal = 30 + (blocks.toInt() * 5)
                }

            }
        }

        if(hasDiscountCard){
            return (costTotal-(costTotal*0.15)).toInt()
        }
        return costTotal

    }

}