package com.autotune.experimentManager.core.interceptor;

import com.autotune.common.experiments.ExperimentTrial;
import com.autotune.experimentManager.utils.EMUtil;

public interface LoadInterceptor extends BaseInterceptor{
    public EMUtil.LoadAvailabilityStatus isLoadAvailable(ExperimentTrial experimentTrial);
}
