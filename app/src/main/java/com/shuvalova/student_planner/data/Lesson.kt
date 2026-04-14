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
    Lesson("l1", "РМП", "Понедельник", "08:30", "305", "Леонтьев Д.А.", "Лекция по Jetpack Compose"),
    Lesson("l2", "Системное программирование", "Понедельник", "10:10", "412", "Токаев Т.И.", "Лабораторная работа №3"),
    Lesson("l3", "РПМ", "Вторник", "10:10", "201", "Донскова Д.А.", "Лабораторная работа"),
    Lesson("l4", "Физкультура", "Вторник", "11:50", "Спортзал", "Магомедов С.К.", "Сдача нормативов"),
    Lesson("l5", "Математическое моделирование", "Среда", "08:30", "108", "Трошина О.В.", "Симплекс-метод"),
    Lesson("l6", "Английский язык", "Среда", "10:10", "205", "Пенькова О.В.", "Technical English"),
    Lesson("l7", "Менеджмент", "Среда", "11:50", "305", "Запорожская С.А.", "Управление процессами")
)