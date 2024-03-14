package com.example.project_final;

public class PenyewaanBarangActivity extends AppCompatActivity {

    private List<Barang> daftarBarang;
    private RecyclerView recyclerView;
    private BarangAdapter adapter;
    private Button tambahBarangBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penyewaan_barang);

        // Inisialisasi komponen view
        recyclerView = findViewById(R.id.recycler_view);
        tambahBarangBtn = findViewById(R.id.tambah_barang_btn);

        // Inisialisasi daftar barang dan adapter
        daftarBarang = new ArrayList<>();
        adapter = new BarangAdapter(daftarBarang);

        // Konfigurasi RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        // Tambahkan event listener untuk tombol tambah barang
        tambahBarangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tampilkan dialog untuk menambahkan barang baru
                showTambahBarangDialog();
            }
        });
    }

    private void showTambahBarangDialog() {
        // Tampilkan dialog untuk menambahkan barang baru
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Tambah Barang");

        // Layout form input barang
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 50, 50, 50);

        final EditText namaBarangEditText = new EditText(this);
        namaBarangEditText.setHint("Nama Barang");
        layout.addView(namaBarangEditText);

        final EditText hargaBarangEditText = new EditText(this);
        hargaBarangEditText.setHint("Harga Barang");
        layout.addView(hargaBarangEditText);

        builder.setView(layout);

        // Tambahkan tombol untuk menyimpan barang
        builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String namaBarang = namaBarangEditText.getText().toString();
                int hargaBarang = Integer.parseInt(hargaBarangEditText.getText().toString());

                // Tambahkan barang baru ke daftar
                Barang barang = new Barang(namaBarang, hargaBarang);
                daftarBarang.add(barang);

                // Update adapter
                adapter.notifyDataSetChanged();
            }
        });

        // Tampilkan dialog
        builder.show();
    }
}

