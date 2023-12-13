package ac.id.ub.filkom.dugdugsehat

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Build
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val visiblePermissionDialogQueue = mutableListOf<String>()

    fun dismissDialog() {
        visiblePermissionDialogQueue.removeLast()
    }

    fun onPermissionResult(
        permission: String,
        isGranted: Boolean
    ) {
        if (!isGranted) {
            visiblePermissionDialogQueue.add(0, permission)
        }
    }

//        var permissionGranted by remember { mutableStateOf(false) }
//        var enableBluetooth by remember { mutableStateOf(false) }
//
//        val bluetoothManager = LocalContext.current.getSystemService(BluetoothManager::class.java)
//        val bluetoothAdapter = bluetoothManager?.adapter
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp)
//        ) {
//            if (bluetoothAdapter == null) {
//                Text(text = stringResource(R.string.bluetooth_doesnt_support))
//            } else {
//                if (!bluetoothAdapter.isEnabled && !enableBluetooth) {
//                    Button(
//                        onClick = {
//                            enableBluetooth = true
//                        }
//                    ) {
//                        Text(text = stringResource(R.string.enable_bluetooth))
//                    }
//                }
//
//                if (enableBluetooth) {
//                    val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
//                    LocalContext.current.startActivity(enableBtIntent)
//                }
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && !permissionGranted) {
//                    requestPermission()
//                }
//            }
//        }
//    }
//
//    @Composable
//    fun requestPermission() {
//        val context = LocalContext.current
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            // Request Bluetooth permissions for Android 12 and above
//            // Note: Adjust the actual permissions you need
//            DisposableEffect(context) {
//                requestMultiplePermissions(context = context, permissions = arrayOf(
//                    android.Manifest.permission.BLUETOOTH_SCAN,
//                    android.Manifest.permission.BLUETOOTH_CONNECT
//                ) )
//            }
//        }
//    }
//
//    @Composable
//    fun requestPermission(context: android.content.Context, permission: String) {
//        if (checkSelfPermission(context, permission) != PERMISSION_GRANTED ) {
//            DisposableEffect(context) {
//                requestPermissions(context as ComponentActivity, arrayOf(permission))
//            }
//        }
//    }
//
//    @Composable
//    fun requestMultiplePermissions(context: android.content.Context, permissions: Array<String>) {
//        if (permissions.any{ checkSelfPermission(context, it) != PERMISSION_GRANTED}) {
//            DisposableEffect(context) {
//                requestPermissions(context as ComponentActivity, permissions)
//            }
//        }
//    }
}