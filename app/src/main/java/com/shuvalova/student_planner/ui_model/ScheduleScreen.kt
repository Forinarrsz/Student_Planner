package com.shuvalova.student_planner.ui_model


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shuvalova.student_planner.data.Lesson
import com.shuvalova.student_planner.data.sampleSchedule

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen(
    onNavigateBack: () -> Unit,
    onLessonClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val groupedSchedule = sampleSchedule.groupBy { it.dayOfWeek }

    val daysOrder = listOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Расписание занятий") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            daysOrder.forEach { day ->
                val lessons = groupedSchedule[day]
                if (lessons != null) {
                    item {
                        Text(
                            text = day,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }

                    items(lessons) { lesson ->
                        ScheduleItemCard(
                            lesson = lesson,
                            onClick = { onLessonClick(lesson.id) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ScheduleItemCard(lesson: Lesson, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = lesson.subject, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
                Text(text = "${lesson.time} | Ауд. ${lesson.room}", style = MaterialTheme.typography.bodySmall)
            }
            Text(text = lesson.professor, style = MaterialTheme.typography.bodySmall)
        }
    }
}