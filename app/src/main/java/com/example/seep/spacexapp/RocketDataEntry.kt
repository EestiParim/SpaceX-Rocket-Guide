package com.example.seep.spacexapp

data class RocketDataEntry(
        val rocketid: Int,
        val id: String,
        val name: String,
        val type: String,
        val active: Boolean,
        val stages: Int,
        val boosters: Int,
        val cost_per_launch: Double,
        val success_rate_pct: Double,
        val first_flight: String,
        val country: String,
        val company: String,
        val height: Height,
        val diameter: Diameter,
        val mass: Mass,
        val payload_weights: List<PayloadWeight>,
        val first_stage: FirstStage,
        val second_stage: SecondStage,
        val engines: Engines,
        val landing_legs: LandingLegs,
        val description: String
)

data class PayloadWeight(
        val id: String,
        val name: String,
        val kg: Double,
        val lb: Double
)

data class Engines(
        val number: Int,
        val type: String,
        val version: String,
        val layout: Any,
        val engine_loss_max: Any,
        val propellant_1: String,
        val propellant_2: String,
        val thrust_sea_level: ThrustSeaLevel,
        val thrust_vacuum: ThrustVacuum,
        val thrust_to_weight: Any
)

data class ThrustVacuum(
        val kN: Double,
        val lbf: Double
)

data class ThrustSeaLevel(
        val kN: Double,
        val lbf: Double
)

data class FirstStage(
        val reusable: Boolean,
        val engines: Int,
        val fuel_amount_tons: Double,
        val burn_time_sec: Double,
        val thrust_sea_level: ThrustSeaLevel,
        val thrust_vacuum: ThrustVacuum
)

data class SecondStage(
        val engines: Int,
        val fuel_amount_tons: Double,
        val burn_time_sec: Double,
        val thrust: Thrust,
        val payloads: Payloads
)

data class Thrust(
        val kN: Double,
        val lbf: Double
)

data class Payloads(
        val option_1: String,
        val option_2: String,
        val composite_fairing: CompositeFairing
)

data class CompositeFairing(
        val height: Height,
        val diameter: Diameter
)

data class Diameter(
        val meters: Double,
        val feet: Double
)

data class Height(
        val meters: Double,
        val feet: Double
)

data class LandingLegs(
        val number: Double,
        val material: String
)

data class Mass(
        val kg: Double,
        val lb: Double
)