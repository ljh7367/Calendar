package service;

    @Service
    public class ScheduleServiceImpl{

        private final ScheduleRepository scheduleRepository;

        public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
            this.scheduleRepository = scheduleRepository;
        }

        // 일정 조회(전체)
        public List<ScheduleResponseDto> findAllSchedules() {
            return scheduleRepository.findAllSchedules();
        }

        // 일정 조회(단건)
        public ScheduleResponseDto findScheduleById(Long id) {
            Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrow(id);
            return new ScheduleResponseDto(schedule);
        }
}
