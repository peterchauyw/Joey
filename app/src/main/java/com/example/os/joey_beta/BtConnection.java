package com.example.os.joey_beta;

import java.util.UUID;

/**
 * Created by OS on 10/06/2016.
 */
public class BtConnection {

    // Debugger monitoring variables
    private static final String TAG = "Bluetooth_service";

    // Service Discovery Protocol register name when the socket is created
    private static final String NAME = "BluetoothSDP";


    // UUID (Uri Unique Identifier) for this application
    private static final UUID btUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    // UUID for chat with other android device ("fa87c0d0-afac-11de-8a39-0800200c9a66");
    // UUID for BT RN42 modules            ("00001101-0000-1000-8000-00805F9B34FB");


}
