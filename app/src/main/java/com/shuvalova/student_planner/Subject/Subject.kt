package com.shuvalova.student_planner.Subject

data class Subject(
    val id: String,
    val name: String,
    val professor: String,
    val credits: Int,
    val currentGrade: String,
    val description: String
) {
    val sampleSubjects = listOf(
        Subject(
            id = "1",
            name = "Разработка мобильных приложений",
            professor = "Леонтьев Д.А.",
            credits = 91,
            currentGrade = "Отлично",
            description = "Разработка нативных Android-приложений с использованием Kotlin и современных компонентов Jetpack Compose. Изучение архитектурных паттернов MVVM, работы с локальными базами данных и сетевыми API."
        ),
        Subject(
            id = "2",
            name = "Системное программирование",
            professor = "Токаев Т.И.",
            credits = 75,
            currentGrade = "Хорошо",
            description = "Низкоуровневая разработка на языке Rust: управление памятью без сборщика мусора, многопоточность"
        ),
        Subject(
            id = "3",
            name = "Мат моделирование",
            professor = "Трошина О.В.",
            credits = 91,
            currentGrade = "Отлично",
            description = "метод изучения реальных объектов, процессов или систем путем построения и исследования их математических моделей (формул, уравнений, алгоритмов)"
        ),
        Subject(
            id = "4",
            name = "Менеджмент",
            professor = "Запорожская С.А.",
            credits = 91,
            currentGrade = "Отлично",
            description = "наука и практика эффективного управления ресурсами (людьми, финансами, временем, информацией) для достижения целей организации"
        )
    )
}