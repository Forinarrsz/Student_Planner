package com.shuvalova.student_planner.ui_model

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shuvalova.student_planner.data.sampleSchedule

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleDetailScreen(
    lessonId: String,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val lesson = sampleSchedule.find { it.id == lessonId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Детали занятия") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (lesson == null) {
            Box(modifier = Modifier.fillMaxSize().padding(paddingValues), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text("Занятие не найдено")
            }
        } else {
            Column(
                modifier = modifier.fillMaxSize().padding(paddingValues).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = lesson.subject, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = lesson.professor, style = MaterialTheme.typography.titleMedium)
                    }
                }

                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        DetailRow(label = "День недели", value = lesson.dayOfWeek)
                        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                        DetailRow(label = "Время", value = lesson.time)
                        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                        DetailRow(label = "Аудитория", value = lesson.room)
                    }
                }

                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Описание", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = lesson.description, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

@Composable
private fun DetailRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = label, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(text = value, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
    }
}