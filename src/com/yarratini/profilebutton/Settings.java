package com.yarratini.profilebutton;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Settings extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        _syncCurrentSelection();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_settings, menu);
        return true;
    }
    
    public void button1Click(View view) {
    	TextView t = (TextView)findViewById(R.id.textView1);
    	RadioGroup rGroup = (RadioGroup)findViewById(R.id.radioGroup1);
    	int checkedId = rGroup.getCheckedRadioButtonId();
    	if (checkedId == R.id.radio0) {
    		t.setText("Normal");
    		_changeProfile(AudioManager.RINGER_MODE_NORMAL);
    	}
    	else if (checkedId == R.id.radio1) {
    		t.setText("Silent");
    		_changeProfile(AudioManager.RINGER_MODE_SILENT);
    	}
    	else if (checkedId == R.id.radio2) {
    		t.setText("Vibrate");
    		_changeProfile(AudioManager.RINGER_MODE_VIBRATE);
    	}
    }
    
    private void _syncCurrentSelection() {
    	RadioGroup rGroup = (RadioGroup)findViewById(R.id.radioGroup1);
    	AudioManager manager = (AudioManager)this.getSystemService(AUDIO_SERVICE);
    	int mode = manager.getRingerMode();
    	if (mode == AudioManager.RINGER_MODE_NORMAL) {
    		rGroup.check(R.id.radio0);
    	}
    	else if (mode == AudioManager.RINGER_MODE_SILENT) {
    		rGroup.check(R.id.radio1);
    	}
    	else if (mode == AudioManager.RINGER_MODE_VIBRATE) {
    		rGroup.check(R.id.radio2);
    	}
    	else {
    		rGroup.clearCheck();
    	}
    }
    private void _changeProfile(int profileType) {
    	AudioManager manager = (AudioManager)this.getSystemService(AUDIO_SERVICE);
    	manager.setRingerMode(profileType);
    }
}
