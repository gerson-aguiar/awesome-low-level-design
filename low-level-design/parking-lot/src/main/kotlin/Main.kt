package gersonaguiar

// Parking Lot - Project - Low Level Design - OOD

enum class VehicleType {
    CAR, MOTORCYCLE, TRUCK
}

class Vehicle(
    val licensePlate: String,
    val type: VehicleType
)

interface ParkingSpot {
    fun isAvailable(): Boolean
    fun parkVehicle(vehicle: Vehicle): Vehicle?
    fun removeVehicle(): Vehicle?
    fun canMatchVehicleType(vehicleType: VehicleType): Boolean
}

class ParkingSpotImpl(
    val id: Int,
): ParkingSpot {
    override fun isAvailable(): Boolean = false

    override fun parkVehicle(vehicle: Vehicle): Vehicle? {
        return null
    }
    override fun removeVehicle(): Vehicle? {
        return null
    }
    override fun canMatchVehicleType(vehicleType: VehicleType): Boolean {
        return false
    }
}

class Floor(
    val idLevel: Int,
    carSpotsCount: Int,
    motorcycleSpotsCount: Int
){
    private val spots: List<ParkingSpot>

    init {
        val carSpots = List(carSpotsCount) {
            ParkingSpotImpl(it)
        }

        val motorcycleSpots = List(motorcycleSpotsCount){
            ParkingSpotImpl(it)
        }

        spots = carSpots + motorcycleSpots
    }

    fun findAvailableParkingSpot(vehicleType: VehicleType): ParkingSpot? {
        return spots.firstOrNull { it.isAvailable() && it.canMatchVehicleType(vehicleType) }
    }

}

class ParkingLot(
    val floors: List<Floor>
){

    fun parkVehicle(vehicle: Vehicle): Boolean{
//        for(floor in this.floors){
//            if(floor.park)
//        }
        return true
    }
}


fun main() {
    val vehicle01 = Vehicle("AAA-111", VehicleType.CAR)
    val vehicle02 = Vehicle("BBB-222", VehicleType.CAR)
    val vehicle03 = Vehicle("CCC-333", VehicleType.TRUCK)

    val floor01 = Floor(1, 1,2)
    val floor02 = Floor(2, 10,20)
    val floor03 = Floor(3, 20, 5)

    val parkingLot = ParkingLot(listOf(floor01,floor02, floor03))

    parkingLot.parkVehicle(vehicle01)



}