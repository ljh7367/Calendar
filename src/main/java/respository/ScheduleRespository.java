package respository;

    @Repository
    public class JdbcTemplateScheduleRepository {

        private final JdbcTemplate jdbcTemplate;

        public JdbcTemplateScheduleRepository(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        }


        // 일정조회(전체) 메서드
        public List<ScheduleResponseDto> findAllSchedules() {
            return jdbcTemplate.query("select * from schedule", scheduleRowMapper());
        }

        // 일정조회(단건) 메서드
        public Optional<Schedule> findScheduleById(Long id) {
            List<Schedule> result = jdbcTemplate.query("select * from schedule where id=?", scheduleRowMapperV2(), id);
            return result.stream().findAny();
        }

        // 일정수정 메서드
        @Override
        public int updateSchedule(Long id, String userName, String title, String contents) {
            return jdbcTemplate.update("update schedule set username = ?, title = ?, contents = ? where id = ?", userName, title, contents, id);
        }
}
