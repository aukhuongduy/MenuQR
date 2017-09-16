package gallery.duyakse04298.fpt.edu.com.project;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.vision.barcode.Barcode;

import gallery.duyakse04298.fpt.edu.com.project.R;
import gallery.duyakse04298.fpt.edu.com.project.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.smooth_slide_right_to_left_in,R.anim.smooth_slide_right_to_left_out);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        Intent intent = getIntent();
        if (intent != null) {
            final Barcode barcode = intent.getParcelableExtra("barcode");
            binding.tvResultDetail.post(new Runnable() {
                @Override
                public void run() {
                    binding.tvResultDetail.setText(barcode.displayValue);
                }
            });

        }
    }
}
