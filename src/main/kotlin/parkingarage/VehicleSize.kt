package parkingarage

enum class VehicleType {
    SMALL, MEDIUM, LARGE
}

enum class ParkingSpaceType {
    SMALL, MEDIUM, LARGE
}

class ParkingSpace(val type: ParkingSpaceType, val spotNumber: Int) {
    var isOccupied: Boolean = false
        private set

    fun park() {
        isOccupied = true
    }

    fun remove() {
        isOccupied = false
    }
}

class Ticket(val spotNumber: Int, val vehicleType: VehicleType)

interface ParkingGarage {
    fun arrive(vehicleType: VehicleType): Ticket?
    fun depart(ticket: Ticket)
    fun searchParkingSpace(vehicleType: VehicleType): ParkingSpace?
}

class ParkingGarageImpl : ParkingGarage {

    private val parkingSpaces = mutableListOf<ParkingSpace>()
    private val parkedCars = mutableMapOf<Int, Ticket>()

    init {
        parkingSpaces.add(ParkingSpace(ParkingSpaceType.SMALL, 1))
        parkingSpaces.add(ParkingSpace(ParkingSpaceType.MEDIUM, 2))
        parkingSpaces.add(ParkingSpace(ParkingSpaceType.LARGE, 3))
        parkingSpaces.add(ParkingSpace(ParkingSpaceType.LARGE, 4))
    }

    override fun arrive(vehicleType: VehicleType): Ticket? {
        // check if space is available
        val parkingSpace = searchParkingSpace(vehicleType)
        return if (parkingSpace != null) {
            parkingSpace.park()
            val ticket = Ticket(parkingSpace.spotNumber, vehicleType)
            //    parkedCars[parkingSpace.spotNumber] = ticket
            ticket
        } else {
            null
        }
    }

    override fun depart(ticket: Ticket) {
        val parkingSpace = parkingSpaces.find { it.spotNumber == ticket.spotNumber }
        parkingSpace?.remove()
        // parkedCars.remove(ticket.spotNumber)
    }

    override fun searchParkingSpace(vehicleType: VehicleType): ParkingSpace? {
        return when (vehicleType) {
            VehicleType.SMALL -> return parkingSpaces.find { it.type == ParkingSpaceType.SMALL && !it.isOccupied }
                ?: parkingSpaces.find { it.type == ParkingSpaceType.MEDIUM && !it.isOccupied }
                ?: parkingSpaces.find { it.type == ParkingSpaceType.LARGE && !it.isOccupied }

            VehicleType.MEDIUM -> parkingSpaces.find { it.type == ParkingSpaceType.MEDIUM && !it.isOccupied }
                ?: parkingSpaces.find { it.type == ParkingSpaceType.LARGE && !it.isOccupied }

            VehicleType.LARGE -> parkingSpaces.find { it.type == ParkingSpaceType.LARGE && !it.isOccupied }
        }
    }


}

fun main() {
    val parkingGarage = ParkingGarageImpl()

    val actions = listOf(
        Pair("arrival", VehicleType.SMALL),
        Pair("arrival", VehicleType.LARGE),
        Pair("arrival", VehicleType.MEDIUM),
        Pair("arrival", VehicleType.LARGE),
        Pair("arrival", VehicleType.MEDIUM),
        Pair("departure", VehicleType.MEDIUM)


    )

    actions.forEach { action ->
        when (action.first) {
            "arrival" -> {
                val ticket = parkingGarage.arrive(action.second)
                if (ticket != null) {
                    println("Vehicle of type ${action.second} parked at spot ${ticket.spotNumber}.")
                } else {
                    println("No available space for vehicle of type ${action.second}.")
                }
            }

            "departure" -> {
                val ticket = Ticket(1, VehicleType.SMALL)
                parkingGarage.depart(ticket)
            }
        }
    }
}
