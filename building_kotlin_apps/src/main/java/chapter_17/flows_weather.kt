package chapter_17

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

data class Weather(val temperature: Double, val description: String)

fun fetchWeatherUpdates(): Flow<Weather> = flow {
    while (true) {
        delay(5000) // Fetch weather every 5 seconds

        // Simulate API call to fetch weather data
        val temperature = getRandomTemperature()
        val description = getRandomWeatherDescription()

        // Emit the latest weather information
        emit(Weather(temperature, description))
    }
}

fun main() = runBlocking {
    // Collect weather updates from the flow
    fetchWeatherUpdates().collect { weather ->
        // Update UI with the latest weather information
        displayWeather(weather)
    }
}

fun displayWeather(weather: Weather) {
    // Code to update UI with the weather information
    println("Temperature: ${weather.temperature}°C, Description: ${weather.description}")
}

// Helper functions to generate random weather data for demonstration purposes
fun getRandomTemperature(): Double = (Math.random() * 30 + (-10)).toDouble()
fun getRandomWeatherDescription(): String = listOf("Sunny", "Cloudy", "Rainy", "Snowy").random()
