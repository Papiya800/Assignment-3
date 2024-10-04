package com.example.assignment3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class ProductActivity extends AppCompatActivity {

    private EditText productNameEditText;
    private TextInputEditText productIdEditText;
    private EditText productPriceEditText;
    private EditText productDescriptionEditText;
    private Spinner categorySpinner;
    private TextView outputTextView;
    private LinearLayout outputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure this matches your layout file name

        // Initialize views
        productNameEditText = findViewById(R.id.product_name);
        productIdEditText = findViewById(R.id.productid);
        productPriceEditText = findViewById(R.id.product_price);
        productDescriptionEditText = findViewById(R.id.product_description);
        categorySpinner = findViewById(R.id.category_spinner);
        Button submitButton;
        submitButton = findViewById(R.id.submit);
        outputTextView = findViewById(R.id.outputText);
        outputLayout = findViewById(R.id.outputLayout);

        // Set onClick listener for the submit button
        submitButton.setOnClickListener(v -> handleSubmit());
    }

    private void handleSubmit() {
        // Retrieve data from input fields
        String productName = productNameEditText.getText().toString().trim();
        String productId = Objects.requireNonNull(productIdEditText.getText()).toString().trim();
        String productPrice = productPriceEditText.getText().toString().trim();
        String productDescription = productDescriptionEditText.getText().toString().trim();
        String category = categorySpinner.getSelectedItem().toString();

        // Validate input
        if (productName.isEmpty() || productId.isEmpty() || productPrice.isEmpty() || productDescription.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Construct output message
        String outputMessage = "Product Name: " + productName +
                "\nProduct ID: " + productId +
                "\nPrice: " + productPrice +
                "\nDescription: " + productDescription +
                "\nCategory: " + category;

        // Display output
        outputTextView.setText(outputMessage);
        outputLayout.setVisibility(View.VISIBLE);
    }
}

