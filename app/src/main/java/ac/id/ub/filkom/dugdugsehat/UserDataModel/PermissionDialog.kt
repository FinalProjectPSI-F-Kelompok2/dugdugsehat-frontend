package ac.id.ub.filkom.dugdugsehat.Model

import ac.id.ub.filkom.dugdugsehat.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.reflect.KFunction0

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PermissionDialog(
    permissionTextProvider: PermissionTextProvider,
    isPermanentlyDeclined: Boolean,
    onDismiss: () -> Unit,
    onOkClick: () -> Unit,
    onGoToSettingsClick: KFunction0<Unit>,
    modifier: Modifier = Modifier
) {
    androidx.compose.material.AlertDialog(
        onDismissRequest = onDismiss,
        buttons = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Divider()
                Text(
                    text = if (isPermanentlyDeclined) {
                        stringResource(R.string.grant_permission)
                    } else {
                        stringResource(R.string.ok)
                    },
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            if (isPermanentlyDeclined) {
                                onGoToSettingsClick()
                            } else {
                                onOkClick()
                            }
                        }
                        .padding(16.dp)
                )
            }
        },
        title = {
            Text(
                text = stringResource(R.string.permission_required)
            )
        }, 
        text = {
               Text(
                   text = permissionTextProvider.getDescription(
                       isPermanentlyDeclined = isPermanentlyDeclined
                   )
               )
        },
        modifier = modifier
    )
}

interface PermissionTextProvider {
    @Composable
    fun getDescription(isPermanentlyDeclined: Boolean): String
}

class BluetoothPermissionTextProvider: PermissionTextProvider {
    @Composable
    override fun getDescription(isPermanentlyDeclined: Boolean): String {
        return if (isPermanentlyDeclined) {
            stringResource(R.string.permanently_declined_desc)
        } else {
            stringResource(R.string.grant_permission_desc)
        }
    }

}