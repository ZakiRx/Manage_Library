import { WordCountPipePipe } from './word-count.pipe';

describe('WordCountPipePipe', () => {
  it('create an instance', () => {
    const pipe = new WordCountPipePipe();
    expect(pipe).toBeTruthy();
  });
});
