import java.util.*

data class Vehicle(val plate: String, val type: VehicleType, val checkInTime: Calendar, val discountCard: String?= null){

    val parkedTime: Long
        get() {
            val MINUTES_IN_MILISECONDS = 600000
            return (Calendar.getInstance().timeInMillis-checkInTime.timeInMillis)/MINUTES_IN_MILISECONDS
        }

    override fun equals(other: Any?): Boolean {
        if(other is Vehicle){
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int = this.plate.hashCode()
}
