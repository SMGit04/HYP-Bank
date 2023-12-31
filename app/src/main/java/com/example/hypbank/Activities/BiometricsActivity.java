package com.example.hypbank.Activities;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.hypbank.Services.ResponseService;
import java.util.concurrent.Executor;

public class BiometricsActivity {
    private final BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    Context context;

    public BiometricsActivity(Context context) {
        biometricPrompt = getPrompt(context);
    }

    @NonNull
    private BiometricPrompt getPrompt(Context context) {

        final BiometricPrompt biometricPrompt;
        BiometricManager biometricManager = BiometricManager.from(context);

        switch (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG)) {
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(context, "Device does not support Biometrics", Toast.LENGTH_SHORT).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(context, "Device Biometrics Not Working", Toast.LENGTH_SHORT).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(context, "No Biometrics Assigned", Toast.LENGTH_SHORT).show();
                break;
        }

        return Execute(context);
    }

    @NonNull
    private BiometricPrompt Execute(Context context) {
        final BiometricPrompt biometricPrompt;
        Executor executor = ContextCompat.getMainExecutor(context);
        ResponseService responseService = new ResponseService();
        biometricPrompt = new BiometricPrompt((FragmentActivity) context, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }
            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(context, "Payment Verified", Toast.LENGTH_SHORT).show();
                responseService.sendTransactionRequestResponse(true, true);
                ((FragmentActivity) context).setVisible(true);
            }
            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                responseService.sendTransactionRequestResponse(true, false);
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Authorize Payment")
                .setDescription("Touch the fingerprint sensor\nTo verify payment")
                .setDeviceCredentialAllowed(true).build();
        return biometricPrompt;
    }

    public void authenticate() {
        biometricPrompt.authenticate(promptInfo);
    }

}
