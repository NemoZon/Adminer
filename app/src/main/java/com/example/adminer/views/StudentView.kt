package com.example.adminer.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.adminer.data.entities.Student
import com.example.adminer.viewmodel.ClassesViewModel
import com.example.adminer.viewmodel.UsersViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun StudentView(
    modifier: Modifier = Modifier,
    student: Student,
    onClick: () -> Unit,
) {
    val classesViewModel: ClassesViewModel = koinViewModel()
    val usersViewModel: UsersViewModel = koinViewModel()
    val usersUIState by usersViewModel.usersUIState.collectAsStateWithLifecycle()
    val classesUIState by classesViewModel.classesUIState.collectAsStateWithLifecycle()
    val email = usersUIState.users.find { it.roleId === student.id }?.email
    val studentClass = classesUIState.classes.find { it.id === student.className }?.title

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        onClick = onClick,
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = student.avatar,
                contentDescription = "Student Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${student.firstName} ${student.lastName}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            if (studentClass != null) {
                Text(
                    text = studentClass,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            if (email != null) {
                Text(
                    text = email,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
