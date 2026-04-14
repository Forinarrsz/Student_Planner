package com.shuvalova.student_planner.data

data class Lesson(
    val id: String,
    val subject: String,
    val dayOfWeek: String,
    val time: String,
    val room: String,
    val professor: String,
    val description: String
)

val sampleSchedule = listOf(
    Lesson("l1", "Мобильная разработка", "Понедельник", "08:30", "305", "Леонтьев Д.А.", "Лекция по Jetpack Compose"),
    Lesson("l2", "Системное программирование", "Понедельник", "10:10", "412", "Токаев Т.И.", "Лабораторная работа №3"),
    Lesson("l3", "Базы данных", "Вторник", "10:10", "201", "Иванова М.С.", "SQL запросы и нормализация"),
    Lesson("l4", "Физкультура", "Вторник", "11:50", "Спортзал", "Петров В.В.", "Сдача нормативов"),
    Lesson("l5", "Математика", "Среда", "08:30", "108", "Сидорова А.А.", "Линейная алгебра"),
    Lesson("l6", "Английский язык", "Среда", "10:10", "205", "Смит Дж.", "Technical English"),
    Lesson("l7", "Операционные системы", "Среда", "11:50", "305", "Козлов И.И.", "Управление процессами")
)