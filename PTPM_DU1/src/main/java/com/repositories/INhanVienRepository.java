package com.repositories;

import com.viewmodel.QLNhanVien;
import java.util.List;

public interface INhanVienRepository {

    List<QLNhanVien> getAll();

    void insert(QLNhanVien nv);

    void update(String id, QLNhanVien nv);

    void delete(String id);

    List<QLNhanVien> search(String string);
}
