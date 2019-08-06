package com.trimbell.vexstats.services.network;

import retrofit2.Call;

public interface RetrofitEventListener {
    void onSuccess(Call call, Object response);
    void onError(Call call, Throwable t);
}
